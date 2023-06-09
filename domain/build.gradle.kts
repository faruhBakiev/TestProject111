plugins {
//    id ("java-library")
//    id ("org.jetbrains.kotlin.jvm")
    Plugins.apply {
        id(javaLibrary)
        id(kotlinJvm)

    }
}

dependencies{

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

}
java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}