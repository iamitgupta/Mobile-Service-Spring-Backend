package com.ms.entity;
public class Camera{
private String rearCamera;
private String features;
private String videoRecording;
private String flash;
private String frontCamera;
private String frontVideoRecording;
public String getRearCamera() {
	return rearCamera;
}
public void setRearCamera(String rearCamera) {
	this.rearCamera = rearCamera;
}
public String getFeatures() {
	return features;
}
public void setFeatures(String features) {
	this.features = features;
}
public String getVideoRecording() {
	return videoRecording;
}
public void setVideoRecording(String videoRecording) {
	this.videoRecording = videoRecording;
}
public String getFlash() {
	return flash;
}
public void setFlash(String flash) {
	this.flash = flash;
}
public String getFrontCamera() {
	return frontCamera;
}
public void setFrontCamera(String frontCamera) {
	this.frontCamera = frontCamera;
}
public String getFrontVideoRecording() {
	return frontVideoRecording;
}
public void setFrontVideoRecording(String frontVideoRecording) {
	this.frontVideoRecording = frontVideoRecording;
}
@Override
public String toString() {
	return "Camera [rearCamera=" + rearCamera + ", features=" + features + ", videoRecording=" + videoRecording
			+ ", flash=" + flash + ", frontCamera=" + frontCamera + ", frontVideoRecording=" + frontVideoRecording
			+ "]";
}


}