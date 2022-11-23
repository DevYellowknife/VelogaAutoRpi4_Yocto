inherit cmake_qt5

SUMMARY = "yellowknife changable skin cluster(VelogaAuto)"
LICENSE = "CLOSED"

DEPENDS += " qtbase qtserialport qtdeclarative dbus qtconnectivity protobuf-native protobuf qtwebsockets"

SRC_URI = "git://git@github.com:/DevYellowknife/VelogaAutoT.git;protocol=ssh;branch=INNO \
          file://swupdater.service \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"


do_install() {

    install -d ${D}//opt/velogaauto/

    install -m 0755 ${B}/framework/services/updateservice/updateservice ${D}/opt/velogaauto

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/swupdater.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += " /opt/velogaauto/*"

SYSTEMD_SERVICE_${PN} = "swupdater.service"

inherit systemd
