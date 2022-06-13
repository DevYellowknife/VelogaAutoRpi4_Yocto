require recipes-qt/qt5/qt5.inc
require recipes-qt/qt5/qt5-git.inc

SUMMARY = "yellowknife changable skin cluster(VelogaAuto)"
LICENSE = "CLOSED"

inherit cmake_qt5

DEPENDS = "qtbase qtserialport qtdeclarative dbus qtconnectivity"

SRC_URI = "git://git@github.com:/DevYellowknife/VelogaAuto.git;protocol=ssh;branch=master \
           file://VelogaAuto.service \
"

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

ARM_INSTRUCTION_SET_armv4 = "arm"
ARM_INSTRUCTION_SET_armv5 = "arm"
ARM_INSTRUCTION_SET_armv7a = "thumb"
ARM_INSTRUCTION_SET_armv7r = "thumb"
ARM_INSTRUCTION_SET_armv7ve = "thumb"
CXXFLAGS += "-fpermissive"
EXTRA_OECMAKE += " \
    -DPORT=Qt \
    -DCROSS_COMPILE=ON \
    -DECM_MKSPECS_INSTALL_DIR=${libdir}${QT_DIR_NAME}/mkspecs/modules \
    -DQML_INSTALL_DIR=${OE_QMAKE_PATH_QML} \
    -DPYTHON_EXECUTABLE=`which python3` \
"

EXTRA_OECMAKE_append_toolchain-clang = " -DCMAKE_CXX_IMPLICIT_INCLUDE_DIRECTORIES:PATH='${STAGING_INCDIR}'"

EXTRA_OECMAKE_append_mipsarch = " -DENABLE_JIT=OFF -DENABLE_C_LOOP=ON "
EXTRA_OECMAKE_append_powerpc = " -DENABLE_JIT=OFF -DENABLE_C_LOOP=ON "
EXTRA_OECMAKE_append_toolchain-clang_mipsarch = " -DUSE_LD_GOLD=OFF "



FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

do_patch() {
    rm -rf ${S}/CANDB
    rm -rf ${S}/temp
    rm -rf ${S}/veloga_auto_app
    rm -rf ${S}/target/build
    mkdir ${S}/target/build
    cd ${S}/target/build
    cmake ..
}

do_compile() {
    cd ${S}/target
    make
}

do_install() {

}

FILES_${PN} += "/opt"

SYSTEMD_SERVICE_${PN} = "VelogaAuto.service"

inherit systemd