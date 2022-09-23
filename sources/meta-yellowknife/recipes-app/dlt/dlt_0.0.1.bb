SUMMARY = "genivi components"
LICENSE = "CLOSED"

SRC_URI = " \
    file://dlt.service \
    file://dlt-daemon \
    file://dlt-receive \
    file://dlt-start \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}//velogaauto

    install -m 755 ${WORKDIR}/dlt-daemon ${D}/velogaauto/
    install -m 755 ${WORKDIR}/dlt-receive ${D}/velogaauto/
    install -m 755 ${WORKDIR}/dlt-start ${D}/velogaauto/

    install -m 0755 -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/dlt.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += " /velogaauto/*"


SYSTEMD_SERVICE_${PN} = "dlt.service"

inherit systemd
