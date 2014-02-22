LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := myjni
LOCAL_SRC_FILES := Calculator.c


include $(BUILD_SHARED_LIBRARY)