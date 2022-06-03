package com.example.movie_1;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.movie_1.databinding.FragmentInfoBinding;
import com.example.movie_1.interfaces.OnChangeToolbarType;
import com.example.movie_1.utils.Define;
import com.google.android.material.tabs.TabLayout;

public class InfoFragment extends Fragment {

    private FragmentInfoBinding binding;
    private OnChangeToolbarType onChangeToolbarType;
    private static InfoFragment infoFragment;
    private OnBackPressedCallback onBackPressedCallback;

    //메서드로 연결
    // 이 객체가 생성되는 시점에 이 메서드를 호출해야지만 연결됨.
//    public void setOnChangeToolbarType(OnChangeToolbarType onChangeToolbarType) {
//        this.onChangeToolbarType = onChangeToolbarType;
//    }


    private InfoFragment(OnChangeToolbarType onChangeToolbarType) {
        this.onChangeToolbarType = onChangeToolbarType;
        // Required empty public constructor
    }


    public static InfoFragment getInstance(OnChangeToolbarType onChangeToolbarType) {
        if (infoFragment == null) {
            infoFragment = new InfoFragment(onChangeToolbarType);
        }
        return infoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // inflater.inflate(R.layout.fragment_info, container, false)

        // 뷰 결합하기 위해 메모리 초기화
        binding = FragmentInfoBinding.inflate(inflater, container, false);
        onChangeToolbarType.onSetupType(Define.PAGE_TITLE_INFO);
        // 여기까지만 하면 NullPoint 뜸
        setupWebView();
        onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Log.d("TAG", "handleOnBackPressed");
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);
        return binding.getRoot();
    }




    private void setupWebView() {
        WebView webView = binding.mWebView;
        webView.loadUrl("https://yts.mx/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // 페이지가 처음 로드될 때 콜백
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 콜백으로 호출
                binding.progressIndicator.setVisibility(View.GONE);
            }
        });
        // 자바 스크립트 허용하는 기능을 넣어줘야 함 (뒤로가기 눌렀을 때 웹페이지의 뒤로 가고싶다면)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        onBackPressedCallback.remove();
    }
}