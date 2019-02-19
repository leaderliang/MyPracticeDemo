package com.test.aidl.bean;

//还要和声明的实体类在一个包里，同时注意不要新建aidl文件，因为你会发现，新建不了，
//提示你名称唯一，此时你新建一个file,名字为Person.aidl就可以，需要特别注意下
parcelable Person;