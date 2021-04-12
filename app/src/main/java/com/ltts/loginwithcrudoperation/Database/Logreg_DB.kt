package com.ltts.loginwithcrudoperation.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.ltts.loginwithcrudoperation.DAO.dao
import com.ltts.loginwithcrudoperation.Registration.Reg

@Database(entities = arrayOf(Reg::class),version = 1,exportSchema = false)
abstract class Logreg_DB: RoomDatabase() {

    companion object{
        var instance:Logreg_DB?=null;
        fun getInstance(cont: Context):Logreg_DB
        {
            if(instance!=null)
            {
                return  instance as Logreg_DB;
            }
            instance= Room.databaseBuilder(cont,Logreg_DB::class.java,"mydb").run { allowMainThreadQueries() }.build();
            return instance as Logreg_DB;
        }
    }
    abstract fun registrationDAO():dao;
}