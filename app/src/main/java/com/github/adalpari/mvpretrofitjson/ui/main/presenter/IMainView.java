package com.github.adalpari.mvpretrofitjson.ui.main.presenter;

import com.github.adalpari.mvpretrofitjson.model.Comic;

import java.util.List;

/**
 * Created by plaza.a on 22/07/2016.
 */
public interface IMainView {
    void onComicsDownloaded(List<Comic> comics);

    void onDownloadError();

    void onResponseError();
}
