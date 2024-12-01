plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
	id("io.freefair.lombok") version "8.10.2"
}

group = "com.olapie"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(20)
	}
}

repositories {
	maven(url = "https://maven.aliyun.com/repository/public")
	maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
	implementation("org.postgresql:postgresql:42.7.4")
	implementation("com.kohlschutter.junixsocket:junixsocket-core:2.10.1")
	runtimeOnly("org.apache.logging.log4j:log4j-layout-template-json")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

configurations.all {
	// refer to https://tomgregory.com/gradle/how-to-exclude-gradle-dependencies/
	exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
