[[_TOC_]]

# プロジェクト名

formula keyboard

## アプリ概要
理系(情報系)が使いやすいようにカスタマイズしたキーボードの作成

## slackのgitlabチャンネルについて
gitlabチャンネルとこのプロジェクト内は連携されています。pushやwikiの編集、merge requestはgitlabチャンネルに通知されるようにしました。 

## エラー対処

### エラーケース1
```
Could not resolve all files for configuration ':app:androidApis'.
Failed to transform file 'android.jar' to match attributes {artifactType=android-mockable-jar, org.gradle.libraryelements=jar, org.gradle.usage=java-runtime, returnDefaultValues=false}
Execution failed for MockableJarTransform: C:\Users\admin\AppData\Local\Android\Sdk\platforms\android-29\android.jar.
Cannot parse result path string:
```
この様なエラーの場合、`build.grandle`の,
```
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.6.3'
    }
}
```
にある、`classpath 'com.android.tools.build:gradle:3.6.3'`を3.4.0あたりに変更してみると、改善する場合がある


