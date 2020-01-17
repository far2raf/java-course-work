plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    implementation(project(":common"))
    implementation(project(":client"))
    implementation(project(":blockingServer"))
    implementation(project(":individualThreadServer"))
    implementation(project(":notBlockingServer"))
    compile("com.fasterxml.jackson.core:jackson-databind:2.0.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}