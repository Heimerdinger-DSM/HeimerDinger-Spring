//package com.example.heimerdinger.domain.feed.service;
//
//
//import com.example.heimerdinger.domain.feed.domain.repository.FeedRepository;
//import com.example.heimerdinger.domain.feed.presentation.dto.response.MypageGetReponse;
//import com.example.heimerdinger.domain.user.domain.User;
//import com.example.heimerdinger.domain.user.domain.repository.UserRepository;
//import com.example.heimerdinger.domain.user.exception.UserNotFoundException;
//import com.example.heimerdinger.domain.user.facade.UserFacade;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import org.springframework.transaction.annotation.Transactional;
//
//
//@RequiredArgsConstructor
//@Service
//public class MyPageGetService {
//
//    private final UserFacade userFacade;
//    private final FeedRepository feedRepository;
//    private final UserRepository userRepository;
//
//    @Transactional(readOnly= true)
//    public MypageGetReponse.MyPageGetDetailResponse execute(String accountId) {
//        User user = userFacade.getCurrentUser();
//        return userRepository.findByAccountId(accountId)
//                .map(feed ->{
//                    MypageGetReponse.MyPageGetDetailResponse myPageGetDetailResponse = MypageGetReponse.MyPageGetDetailResponse.builder()
//                            .name(user.getNickName())
//                            .accountId(user.getAccountId())
//                            .feeds(feedRepository.)
//                            .hearts()
//                            .build();
//                    return myPageGetDetailResponse;
//                })
//                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
//
//    }
//}
