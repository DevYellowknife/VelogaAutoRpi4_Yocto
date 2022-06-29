inherit cmake_qt5

SUMMARY = "yellowknife changable skin cluster(VelogaAuto)"
LICENSE = "CLOSED"

DEPENDS += " qtbase qtserialport qtdeclarative dbus qtconnectivity protobuf-native protobuf "

SRC_URI = "git://git@github.com:/DevYellowknife/VelogaAuto.git;protocol=ssh;branch=master \
           file://VelogaAuto.service \
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
    install -m 744 ${B}/framework/api/appservice/libvappservice.a ${D}/velogaauto/libvappservice.a
    install -m 744 ${B}/framework/api/bleservice/libvbleservice.a ${D}/velogaauto/libvbleservice.a
    install -m 744 ${B}/framework/api/canservice/libvcanservice.a ${D}/velogaauto/libvcanservice.a
    install -m 755 ${B}/framework/services/bleservice/bleservice ${D}/velogaauto/bleservice
    install -m 755 ${B}/framework/services/canservice/canservice ${D}/velogaauto/canservice
    install -m 755 ${B}/framework/services/velogaservice/velogaservice ${D}/velogaauto/velogaservice
    install -m 755 ${B}/framework/services/wifiservice/wifiservice ${D}/velogaauto/wifiservice
#    install -m 755 ${B}/framework/services/windowservice ${D}/velogaauto/windowservice
}

FILES_${PN} += " /velogaauto/*"

FILES_${PN}-staticdev += " /velogaauto/*.a"
FILES_${PN}-dev += " /velogaauto/*.la"


#SYSTEMD_SERVICE_${PN} = "VelogaAuto.service"

#inherit systemd
