package com.ltts.loginwithcrudoperation.DAO

import androidx.room.*
import com.ltts.loginwithcrudoperation.Registration.Reg

@Dao
interface dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(registration: Reg)

    @Query("select * from registration where email=:email and password=:pass")
    fun checkLogin(email:String,pass:String):List<Any> ;

    @Query("select * from registration where _id=:id")
    fun fetchUser(id:Int):Reg;

    @Delete
    fun deleteUser(registration:Reg):Int
}