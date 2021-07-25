package com.example.dependencyinjectionwithdagger2;

import java.util.List;
import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Module
public class GitHubModule {

    public interface GitHubApiInterface {
        @GET("/users/{user}/repos")
        Call<List<Repository>> getRepository(@Path("user") String userName);
    }

    @Provides
    @UserScope // needs to be consistent with the component scope
    public GitHubApiInterface providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubApiInterface.class);
    }
}
