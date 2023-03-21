# Getting Started

## Required Packages for the Build Host

Ubuntu 또는 Debian Linux 배포판이 있는 헤드리스 시스템에서 이미지를 빌드하는 데 필요한 패키지는 다음과 같습니다.

이미 설치된 경우 건너 뛸 수 있습니다.

```
$ sudo apt install gawk wget git diffstat unzip texinfo gcc build-essential chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev python3-subunit mesa-common-dev zstd liblz4-tool file locales
$ sudo locale-gen en_US.UTF-8
```

## Build Veloga Auto Image

다음 명령으로 시작 할 수 있습니다.

```
$ source setup.sh
$ bitbake velogaauto-image
```
