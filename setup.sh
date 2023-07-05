#!/bin/bash


git clone -b kirkstone git://git.yoctoproject.org/poky.git

cd poky 

git clone -b kirkstone git://git.openembedded.org/meta-openembedded
git clone -b 6.4 git://code.qt.io/yocto/meta-qt6.git
git clone -b kirkstone git://git.yoctoproject.org/meta-raspberrypi
git clone -b 6.4 git@github.com:DevYellowknife/meta-yellowknife.git

source oe-init-build-env ../build

export MACHINE=raspberrypi4-64
