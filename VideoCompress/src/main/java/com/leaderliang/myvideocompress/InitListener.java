package com.leaderliang.myvideocompress;

/**
 *
 * @author karan
 * @date 13/2/15
 */
public interface InitListener {
    void onLoadSuccess();

    void onLoadFail(String reason);
}
