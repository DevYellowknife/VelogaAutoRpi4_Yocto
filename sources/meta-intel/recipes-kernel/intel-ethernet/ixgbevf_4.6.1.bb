SUMMARY="ixgbevf kernel driver for Intel Magnolia Park 10GbE"
DESCRIPTION="This virtual function driver supports kernel versions 2.6.x and newer \
This driver supports 82599, X540, X550, and X552-based virtual function devices \
that can only be activated on kernels that support SR-IOV. \
SR-IOV requires the correct platform and OS support. \
The guest OS loading this driver must support MSI-X interrupts."

HOMEPAGE = "https://sourceforge.net/projects/e1000/"
SECTION = "kernel/network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/${BP}/COPYING;md5=a216b4192dc6b777b6f0db560e9a8417"

SRC_URI = "https://sourceforge.net/projects/e1000/files/ixgbevf%20stable/${PV}/${BP}.tar.gz \
           file://0001-ixgbevf-skip-host-depmod.patch \
           "

SRC_URI[md5sum] = "e98bc636fea13cb62c11433159147851"
SRC_URI[sha256sum] = "2ca0a0a836d006375fa28a999e0b139bda93110a22ee3742ae1c8d0ac9130a41"

UPSTREAM_CHECK_URI = "https://sourceforge.net/projects/e1000/files/ixgbevf%20stable/"
UPSTREAM_CHECK_REGEX = "ixgbevf%20stable/(?P<pver>\d+(\.\d+)+)/"

CVE_PRODUCT = "linux:linux_kernel_ixgbe"

S = "${WORKDIR}/${BP}/src"
MODULES_INSTALL_TARGET = "install"

EXTRA_OEMAKE='KSRC="${STAGING_KERNEL_BUILDDIR}" KVER="${KERNEL_VERSION}" INSTALL_MOD_PATH="${D}"'

KERNEL_MODULE_AUTOLOAD_append_intel-core2-32 = " ixgbevf"
KERNEL_MODULE_AUTOLOAD_append_intel-corei7-64 = " ixgbevf"

inherit module

do_install_append () {
        # Install scripts/set_irq_affinity
        install -d      ${D}${sysconfdir}/network
        install -m 0755 ${S}/../scripts/set_irq_affinity  ${D}${sysconfdir}/network

        rm -rf ${D}${prefix}/man
}

PACKAGES += "${PN}-script"

FILES_${PN}-script += "${sysconfdir}/network/set_irq_affinity"
