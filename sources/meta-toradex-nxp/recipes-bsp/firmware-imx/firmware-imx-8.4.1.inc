# Copyright (C) 2012-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP
# Copyright (C) 2018 O.S. Systems Software LTDA.
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=fd4b227530cd88a82af6a5982cfb724d"

SRC_URI = " \
    ${FSL_MIRROR}/firmware-imx-${PV}.bin;fsl-eula=true \
"

SRC_URI[md5sum] = "70bdefdd7fb58f782237acf4c648f5cd"
SRC_URI[sha256sum] = "f04b2deb4f126e6b6cd4460462292acd72183b9f799e3b873fb390ff0f18eb55"

S = "${WORKDIR}/firmware-imx-${PV}"

inherit fsl-eula-unpack
