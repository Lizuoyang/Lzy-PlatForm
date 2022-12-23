 package com.lzy.platform.base.service;

 /**
  * iaction
  *
  * @date 2022/06/21
  */
 @FunctionalInterface
 public interface IAction<T> {

     /**
      * 执行回调
      * @param param
      */
     void run(T param);
 }

