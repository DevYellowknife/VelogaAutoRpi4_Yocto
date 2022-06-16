# get additional scfw binaries provided in:
SCFW_TDX_SRC ?= "git://github.com/toradex/i.MX-System-Controller-Firmware.git"

SRC_URI += "${SCFW_TDX_SRC};branch=master;protocol=https;fsl-eula=true"

SRCREV = "acfaf180e5bfae166782e2ee91f6dffc84af3225"

do_patch[prefuncs] += "do_cp_scfw"
do_cp_scfw () {
	cp ${WORKDIR}/git/src/scfw_export_*/build_*/*-scfw-tcm.bin ${S}/
}

# get the matching SCFW for NXP's boards for the 2.3.1 BSP
PV = "1.3.1"
SRC_URI[md5sum] = "f3b4b5e63dec7ce8ed73c2021d84c467"
SRC_URI[sha256sum] = "a5fb090d92db775d1b87f814b00c446e4e59816bd5ea9f50ca709da74fc74182"
LIC_FILES_CHKSUM = "file://COPYING;md5=fd4b227530cd88a82af6a5982cfb724d"
