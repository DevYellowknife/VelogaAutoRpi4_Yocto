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

PACKAGES += "${PN}-mkspecs"

FILES_${PN}-mkspecs = "\
    ${OE_QMAKE_PATH_QT_ARCHDATA}/mkspecs \
"

FILES_${PN}-dev += " \
    ${OE_QMAKE_PATH_LIBS}/lib*${SOLIBSDEV} \
    ${OE_QMAKE_PATH_LIBS}/pkgconfig \
    ${OE_QMAKE_PATH_LIBS}/cmake/* \
    ${OE_QMAKE_PATH_LIBS}/*.prl \
    ${OE_QMAKE_PATH_LIBS}/*.la \
    ${OE_QMAKE_PATH_DATA}/* \
    ${OE_QMAKE_PATH_HEADERS}/* \
"

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