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
    Call<List<TaskMain>> getTasksMain();

    @GET("GetTaskSubLvl1")
    Call<List<TaskSubLevel>> getTaskSubLevel(@Query("mainId") int mainId);

    /**
     * زیر فعالیت
     * @param subLevelId
     * @return
     */
    @GET("GetTaskTypeList")
    Call<List<TaskTypes>> getTaskTypeList(@Query("subLevelId") int subLevelId);

    @GET("GetTaskType")
    Call<TaskType> getTaskType(@Query("type") int type);

    @GET("GetGroupMains")
    Call<List<GroupMain>> getGroupMain();

    @GET("GetGroupCodes")
    Call<List<GroupCode>> getGroupCode(@Query("mainCode") int mainCode);

    @GET("GetChannels")
    Call<List<Channel>> getChannels();

    @GET("GetTestTypes")
    Call<List<TestType>> getTestTypes(@Query("mainCode") int groupCode);

    @GET("GetTaskBooks")
    Call<List<Book>> getBooks();

    @GET("GetCategories")
    Call<List<Category>> getCategories();

    @GET("GetLocations")
    Call<List<Location>> getLocations();

    @GET("GetCourse")
    Call<List<Course>> getCourses(@Query("groupCode") int groupCode);

    @GET("GetTestDate")
    Call<List<TestDate>> getTestDate(@Query("groupCode") int groupCode);

    @GET("LoginUser")
    Call<Login> loginUser(@Query("username") String username, @Query("password") String password);

    @GET("GetManagers")
    Call<List<Managers>> getManagers();

    @POST("Insert?token=SM65wZG15HJUJTGN3TTcYayfFwRmHUnFuVDDbPTHiwYqoDvkqXhMcY46guMrsx%2bN%2bBFeVMZihLCdiWgVxTggo1x4DMubX5OGLq6%2bnk3%2bu0sQ0Rfa%2fqth%2fDvpx8mHFJ8O")
    Call<Mete> insertTask(@Body Task task);

}
