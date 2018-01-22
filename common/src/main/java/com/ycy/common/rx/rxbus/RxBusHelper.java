package com.ycy.common.rx.rxbus;

/**
 * --------------------------------------------------
 * 作       者： 易成勇
 * 文件名：RxBusHelper
 * 创 建 日 期 ： 2018/1/13  17:42
 * 描      述 ：
 * 修 订 历 史:
 * --------------------------------------------------
 */

public class RxBusHelper {
//    /**
//     * 发布消息
//     *
//     * @param o
//     */
//    public static void post(Object o) {
//        RxBus.getDefault().post(o);
//    }
//
//    /**
//     * 接收消息,并在主线程处理
//     *
//     * @param aClass
//     * @param disposables 用于存放消息
//     * @param listener
//     * @param <T>
//     */
//    public static <T> void doOnMainThread(Class<T> aClass, CompositeDisposable disposables, OnEventListener<T> listener) {
//        disposables.add(RxBus.getDefault().toFlowable(aClass).observeOn(AndroidSchedulers.mainThread()).subscribe(listener::onEvent, throwable -> listener.onError(new ErrorBean(ErrorCode.ERROR_CODE_RXBUS, ErrorCode.ERROR_DESC_RXBUS))));
//    }
//
//    public static <T> void doOnMainThread(Class<T> aClass, OnEventListener<T> listener) {
//        RxBus.getDefault().toFlowable(aClass).observeOn(AndroidSchedulers.mainThread()).subscribe(listener::onEvent, throwable -> listener.onError(new ErrorBean(ErrorCode.ERROR_CODE_RXBUS, ErrorCode.ERROR_DESC_RXBUS)));
//    }
//
//    /**
//     * 接收消息,并在子线程处理
//     *
//     * @param aClass
//     * @param disposables
//     * @param listener
//     * @param <T>
//     */
//    public static <T> void doOnChildThread(Class<T> aClass, CompositeDisposable disposables, OnEventListener<T> listener) {
//        disposables.add(RxBus.getDefault().toFlowable(aClass).subscribeOn(Schedulers.newThread()).subscribe(listener::onEvent, throwable -> listener.onError(new ErrorBean(ErrorCode.ERROR_CODE_RXBUS, ErrorCode.ERROR_DESC_RXBUS))));
//    }
//
//    public static <T> void doOnChildThread(Class<T> aClass, OnEventListener<T> listener) {
//        RxBus.getDefault().toFlowable(aClass).subscribeOn(Schedulers.newThread()).subscribe(listener::onEvent, throwable -> listener.onError(new ErrorBean(ErrorCode.ERROR_CODE_RXBUS, ErrorCode.ERROR_DESC_RXBUS)));
//    }
//
//    public interface OnEventListener<T> {
//        void onEvent(T t);
//
//        void onError(ErrorBean errorBean);
//    }

}