
package com.ms.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ms.util.MobileUtil;

@Document(collection = "mobile")
public class Mobile {

	@Id
	private Long mobileId;

	private String brand;
	private String title;
	private Long ram;
	private Long internalMemory;
	private Double screenSize;
	private Double price;
	private LocalDate releseDate;
	private Long frontCamera;
	private Long rearCamera;
	private Long specScore;
	private Long batterySize;
	private Boolean upcoming;
	private Long popularity;
	private General general;
	private Display display;
	private Memory memory;
	private Connectivity connectivity;
	private Extra extra;
	private Camera camera;
	private Technical technical;
	private Multimedia multimedia;
	private Battery battery;
	private List<String> images = null;

	public Mobile() {
		this.mobileId = MobileUtil.getMobileId();
		this.popularity = 1l;
	}

	public Long getMobileId() {
		return mobileId;
	}

	public void setMobileId(Long mobileId) {
		this.mobileId = mobileId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getRam() {
		return ram;
	}

	public void setRam(Long ram) {
		this.ram = ram;
	}

	public Long getInternalMemory() {
		return internalMemory;
	}

	public void setInternalMemory(Long internalMemory) {
		this.internalMemory = internalMemory;
	}

	public Double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(Double screenSize) {
		this.screenSize = screenSize;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getReleseDate() {
		return releseDate;
	}

	public void setReleseDate(LocalDate releseDate) {
		this.releseDate = releseDate;
	}

	public Long getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(Long frontCamera) {
		this.frontCamera = frontCamera;
	}

	public Long getRearCamera() {
		return rearCamera;
	}

	public void setRearCamera(Long rearCamera) {
		this.rearCamera = rearCamera;
	}

	public Long getSpecScore() {
		return specScore;
	}

	public void setSpecScore(Long specScore) {
		this.specScore = specScore;
	}

	public Boolean getUpcoming() {
		return upcoming;
	}

	public void setUpcoming(Boolean upcoming) {
		this.upcoming = upcoming;
	}
	
	

	public Long getPopularity() {
		return popularity;
	}

	public void setPopularity(Long popularity) {
		this.popularity = popularity;
	}

	public General getGeneral() {
		return general;
	}

	public void setGeneral(General general) {
		this.general = general;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public Connectivity getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(Connectivity connectivity) {
		this.connectivity = connectivity;
	}

	public Extra getExtra() {
		return extra;
	}

	public void setExtra(Extra extra) {
		this.extra = extra;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public Technical getTechnical() {
		return technical;
	}

	public void setTechnical(Technical technical) {
		this.technical = technical;
	}

	public Multimedia getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Long getBatterySize() {
		return batterySize;
	}

	public void setBatterySize(Long batterySize) {
		this.batterySize = batterySize;
	}

	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", brand=" + brand + ", title=" + title + ", ram=" + ram
				+ ", internalMemory=" + internalMemory + ", screenSize=" + screenSize + ", price=" + price
				+ ", releseDate=" + releseDate + ", frontCamera=" + frontCamera + ", rearCamera=" + rearCamera
				+ ", specScore=" + specScore + ", batterySize=" + batterySize + ", upcoming=" + upcoming
				+ ", popularity=" + popularity + ", general=" + general + ", display=" + display + ", memory=" + memory
				+ ", connectivity=" + connectivity + ", extra=" + extra + ", camera=" + camera + ", technical="
				+ technical + ", multimedia=" + multimedia + ", battery=" + battery + ", images=" + images + "]";
	}

}
