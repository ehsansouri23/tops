package com.kanoon.topapps.data.remote;

import com.kanoon.topapps.Mete;
import com.kanoon.topapps.data.model.Book;
import com.kanoon.topapps.data.model.Category;
import com.kanoon.topapps.data.model.Channel;
import com.kanoon.topapps.data.model.Course;
import com.kanoon.topapps.data.model.GroupCode;
import com.kanoon.topapps.data.model.GroupMain;
import com.kanoon.topapps.data.model.Location;
import com.kanoon.topapps.data.model.Login;
import com.kanoon.topapps.data.model.Managers;
import com.kanoon.topapps.data.model.Task;
import com.kanoon.topapps.data.model.TaskMain;
import com.kanoon.topapps.data.model.TaskSubLevel;
import com.kanoon.topapps.data.model.TaskType;
import com.kanoon.topapps.data.model.TaskTypes;
import com.kanoon.topapps.data.model.TestDate;
import com.kanoon.topapps.data.model.TestType;

import java.io.CharArrayReader;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ehsan on 2/13/2018.
 */

public interface APIService {

    @GET("GetTaskMains")
    Call<List<TaskMain>> getTasksMain(@Query("token") String token);

    @GET("GetTaskSubLvl1")
    Call<List<TaskSubLevel>> getTaskSubLevel(@Query("mainId") int mainId, @Query("token") String token);

    /**
     * زیر فعالیت
     * @param subLevelId
     * @return
     */
    @GET("GetTaskTypeList")
    Call<List<TaskTypes>> getTaskTypeList(@Query("subLevelId") int subLevelId, @Query("token") String token);

    @GET("GetTaskType")
    Call<TaskType> getTaskType(@Query("type") int type, @Query("token") String token);

    @GET("GetGroupMains")
    Call<List<GroupMain>> getGroupMain(@Query("token") String token);

    @GET("GetGroupCodes")
    Call<List<GroupCode>> getGroupCode(@Query("mainCode") int mainCode, @Query("token") String token);

    @GET("GetChannels")
    Call<List<Channel>> getChannels(@Query("token") String token);

    @GET("GetTestTypes")
    Call<List<TestType>> getTestTypes(@Query("mainCode") int groupCode, @Query("token") String token);

    @GET("GetTaskBooks")
    Call<List<Book>> getBooks(@Query("token") String token);

    @GET("GetCategories")
    Call<List<Category>> getCategories(@Query("token") String token);

    @GET("GetLocations")
    Call<List<Location>> getLocations(@Query("token") String token);

    @GET("GetCourse")
    Call<List<Course>> getCourses(@Query("groupCode") int groupCode, @Query("token") String token);

    @GET("GetTestDate")
    Call<List<TestDate>> getTestDate(@Query("groupCode") int groupCode, @Query("token") String token);

    @GET("LoginUser")
    Call<Login> loginUser(@Query("username") String username, @Query("password") String password);

    @GET("GetManagers")
    Call<List<Managers>> getManagers(@Query("token") String token);

    @POST("Insert")
    Call<Mete> insertTask(@Query("token") String token, @Body Task task);

}
