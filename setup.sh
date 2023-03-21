#!/bin/bash


git clone -b kirkstone git://git.yoctoproject.org/poky.git

cd poky 

git clone -b kirkstone git://git.openembedded.org/meta-openembedded
git clone -b kirkstone https://github.com/meta-qt5/meta-qt5
git clone -b kirkstone git://git.yoctoproject.org/meta-raspberrypi
git clone -b main git@github.com:DevYellowknife/meta-yellowknife.git

source oe-init-build-env ../build

export MACHINE=raspberrypi4
