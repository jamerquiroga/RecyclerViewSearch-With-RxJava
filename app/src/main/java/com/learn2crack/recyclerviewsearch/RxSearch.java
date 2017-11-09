package com.learn2crack.recyclerviewsearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by jquirogl on 09/11/2017.
 */

public class RxSearch  {

    public static Observable<String> fromSearchView(@NonNull final SearchView searchView){


        final BehaviorSubject<String> subject = BehaviorSubject.create("");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                subject.onCompleted();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!newText.isEmpty()){
                    subject.onNext(newText);
                }
                return true;
            }
        });

        return subject;

    }
}
