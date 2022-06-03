package com.example.movie_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.movie_1.adapter.MovieAdapter;
import com.example.movie_1.databinding.FragmentMovieBinding;
import com.example.movie_1.interfaces.OnMovieItemClicked;
import com.example.movie_1.models.Movie;
import com.example.movie_1.models.YtsData;
import com.example.movie_1.repository.MovieService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment implements OnMovieItemClicked {

    // 안드로이드에서 만들어 준 클래스
    private FragmentMovieBinding binding;
    private static final String TAG = MovieFragment.class.getName();
    // 불변성 유지, 한번 올라가면 데이터를 변경하지 못하게 하도록. 성능에도 좋음.
    // 여기서 통신 요청을 할 예정
    private MovieService movieService;

    private MovieAdapter movieAdapter;

    private List<Movie> list = new ArrayList<>();
    private int currentPageNumber = 1;
    // 스크롤 시 중복이벤트 발생 해결 방안
    private boolean preventDuplicateScrollEvent = true;

    OnMovieItemClicked clicked;


    public MovieFragment() {
        // Required empty public constructor
    }

    public void setMovieItemClicked(OnMovieItemClicked movieItemClicked) {
        this.clicked = clicked;
    }

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movieService = MovieService.retrofit.create(MovieService.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // findViewById 대체 (뷰 바인딩 활용)
        // inflater.inflate(R.layout.fragment_movie, container, false)
        binding = FragmentMovieBinding.inflate(inflater, container, false);
        // RecyclerView 만들어 주기

        // 통신 받기 전이기 때문에 아직 없음 / 안드로이드 입체적으로 생각해야 함.
        //
        setupRecyclerView(list); // 처음에는 아무 것도 없는 list 넘겨 줌
        requestMoviesData(currentPageNumber);

        return binding.getRoot();
    }

    // requestPage -> limit 만큼 데이터를 가져오는데 그 다음 데이터를 보고 싶으면 page를 다음으로 하면 됨
    private void requestMoviesData(int requestPage) {

        int ITEM_LIMIT = 10;

        Log.d(TAG, "통신 요청");

        movieService.repoContributors("rating", ITEM_LIMIT, requestPage)
                .enqueue(new Callback<YtsData>() {
                    @Override
                    public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                        if (response.isSuccessful()) {
                            // 통신을 통해서 데이터를 넘겨 받았으면 adapter 에 데이터를 전달해서
                            // 화면을 갱신 처리하면 됨.
                            List<Movie> list = response.body().getData().getMovies();
                            movieAdapter.addItem(list);
                            currentPageNumber++;
                            preventDuplicateScrollEvent = true;
                            setVisibilityProgressBar(View.GONE);

                        }
                    }

                    @Override
                    public void onFailure(Call<YtsData> call, Throwable t) {
                        Log.d(TAG, t.getMessage());
                        setVisibilityProgressBar(View.GONE);
                        // xml 파일에 텍스트 뷰 만들어서 -> 네트워트가 불안정 합니다. show
                    }
                });
    }

    // 통신 해서 Json 파싱해서 받은 다음에 매개변수로 데이터를 넘길 예정
    private void setupRecyclerView(List<Movie> movieList) {
        // 1. 어뎁터
        movieAdapter = new MovieAdapter(); // addItemList 메서드를 다른 곳에서 쓰기 위해 멤버변수로 선언
        movieAdapter.setMovieItemClicked(this);
        // 생성자를 통해 넘겨받을 수도 있음. 이런 것은 버튼눌렀을 때 등등 활용 가능
        movieAdapter.addItemList(movieList);
        // 2. 매니저
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        // 3. xml 파일에 선언한 recyclerView 에 셋팅
        binding.movieRecyclerView.setAdapter(movieAdapter);
        binding.movieRecyclerView.setLayoutManager(manager);
        binding.movieRecyclerView.hasFixedSize();
        // 이벤트 리스너 달 수 있음.
        binding.movieRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (preventDuplicateScrollEvent) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) (binding.movieRecyclerView.getLayoutManager());
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, "lastVisibleItemPosition: " + lastVisibleItemPosition);
                    // adapter (데이터)의 list.size 뽑아올 수 있음
                    // 한 번 통신했을 때 사이즈가 (10)인 것을 알 수 있음. limit 정해줬기 때문에
                    // LinearLayout은 인덱스로 뽑기 때문에 9가 나옴. --> -1 해줘야함
                    int itemTotalCount = binding.movieRecyclerView.getAdapter().getItemCount() - 1;

                    if (lastVisibleItemPosition == itemTotalCount) {
                        if (currentPageNumber != 1) {
                            // 토스트 메세지 안없어짐. 이벤트 리스너가 계속 호출됨. 나중에 버그 있을 수 있음.
                            Log.d(TAG, "check event");
                            // 네트워크 요청
                            preventDuplicateScrollEvent = false;
                            requestMoviesData(currentPageNumber);
                        }

                    }
                }


            }
        });

    }

    private void setVisibilityProgressBar(int visible) {
        binding.progressIndicator.setVisibility(visible);
    }


    @Override
    public void selectedItem(Movie movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.PARAM_NAME_1, movie); // Movie 클래스 직렬화 (Serializable)
        // 직렬화 --> Object 단위를 byte 단위로 변환해서 던진다.
        startActivity(intent);
    }
}