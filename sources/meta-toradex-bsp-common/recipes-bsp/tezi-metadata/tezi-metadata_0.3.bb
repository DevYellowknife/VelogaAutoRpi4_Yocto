DESCRIPTION = "Toradex Easy Installer Metadata"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://prepare.sh \
    file://wrapup.sh \
    file://toradexlinux.png \
    file://marketing.tar;unpack=false \
"

inherit deploy nopackages

do_deploy () {
    install -m 644 ${WORKDIR}/prepare.sh ${DEPLOYDIR}
    install -m 644 ${WORKDIR}/wrapup.sh ${DEPLOYDIR}
    install -m 644 ${WORKDIR}/toradexlinux.png ${DEPLOYDIR}
    install -m 644 ${WORKDIR}/marketing.tar ${DEPLOYDIR}
}

addtask deploy before do_build after do_install

PACKAGE_ARCH = "${MACHINE_ARCH}"
