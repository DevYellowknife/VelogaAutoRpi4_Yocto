
SUMMARY = "Connman config to ignore wired interface on qemu machines"
DESCRIPTION = "This is the ConnMan configuration to avoid touching wired \
network interface inside qemu machines."

LICENSE = "CLOSED"

SRC_URI = " \
	file://main.conf \
"

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} += " ${sysconfdir}/*"

# Kernel IP-Config is perfectly capable of setting up networking passed in via ip=
do_install_append() {
    mkdir -p ${D}${sysconfdir}/connman
    cp ${S}/main.conf ${D}${sysconfdir}/connman/main.conf
}
