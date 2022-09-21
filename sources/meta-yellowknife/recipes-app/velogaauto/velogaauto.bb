inherit cmake_qt5

SUMMARY = "yellowknife changable skin cluster(VelogaAuto)"
LICENSE = "CLOSED"

DEPENDS += " qtbase qtserialport qtdeclarative dbus qtconnectivity protobuf-native protobuf qtwebsockets"

SRC_URI = "git://git@github.com:/DevYellowknife/VelogaAuto.git;protocol=ssh;branch=master \
           file://velogaauto.service \
"

SRCREV = "${AUTOREV}"
#SRCREV = "ccad7eab27b4dcf17bd277261cc335318e3fa8c7"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git/target"


do_patch() {
    rm -rf ${S}/../CANDB
    rm -rf ${S}/../temp
    rm -rf ${S}/../veloga_auto_app
}

do_install() {
    install -d ${D}//velogaauto

    install -m 755 ${B}/apps/velogacluster/veloga-cluster ${D}/velogaauto/veloga-cluster
    install -m 755 ${B}/framework/services/bleservice/bleservice ${D}/velogaauto/bleservice
    install -m 755 ${B}/framework/services/canservice_rasp4/canservice ${D}/velogaauto/canservice
    install -m 755 ${B}/framework/services/velogaservice/velogaservice ${D}/velogaauto/velogaservice
    install -m 755 ${B}/framework/services/wifiservice/wifiservice ${D}/velogaauto/wifiservice

    cp -r ${B}/framework/services/velogaservice/process_json ${D}/velogaauto/process_json

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/velogaauto.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += " /velogaauto/*"

FILES_${PN}-staticdev += " /velogaauto/*.a"
FILES_${PN}-dev += " /velogaauto/*.la"


SYSTEMD_SERVICE_${PN} = "velogaauto.service"

inherit systemd
