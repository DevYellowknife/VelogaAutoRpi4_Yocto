inherit cmake_qt5

SUMMARY = "yellowknife changable skin cluster(VelogaAuto)"
LICENSE = "CLOSED"

DEPENDS += " qtbase qtserialport qtdeclarative dbus qtconnectivity protobuf-native protobuf qtwebsockets"

SRC_URI = "git://git@github.com:/DevYellowknife/VelogaAuto.git;protocol=ssh;branch=master \
          file://swupdater.service \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/target"


do_patch() {
    rm -rf ${S}/../CANDB
    rm -rf ${S}/../temp
    rm -rf ${S}/../veloga_auto_app
}

do_install() {

    install -d ${D}//opt/velogaauto/

    install -m 0755 ${B}/framework/services/updateservice/updateservice ${D}/opt/velogaauto

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/swupdater.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += " /opt/velogaauto/*"

SYSTEMD_SERVICE_${PN} = "swupdater.service"

inherit systemd
