#include <string.h>
#include <jni.h>
#include <android/log.h>


JNIEXPORT jint JNICALL Java_com_example_ndksample_NativeLib_add(JNIEnv* env, jobject obj, jint n1, jint n2){
	return n1+n2;
}

JNIEXPORT jint JNICALL Java_com_example_ndksample_NativeLib_sub(JNIEnv* env, jobject obj, jint n1, jint n2){
	return n1-n2;
}

JNIEXPORT jint JNICALL Java_com_example_ndksample_NativeLib_mul(JNIEnv* env, jobject obj, jint n1, jint n2){
	return n1*n2;
}

JNIEXPORT jint JNICALL Java_com_example_ndksample_NativeLib_div(JNIEnv* env, jobject obj, jint n1, jint n2){
	return n1/n2;
}
