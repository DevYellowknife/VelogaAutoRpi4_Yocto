#update to 6.2.4.p4.8
PV = "6.2.4.p4.8-aarch32"
PV_aarch64 = "6.2.4.p4.8-aarch64"
LIC_FILES_CHKSUM = "file://COPYING;md5=fd4b227530cd88a82af6a5982cfb724d"
MD5SUM_arm = "0e18ffca4b9c648fb41586fa53647541"
SHA256SUM_arm = "2804c3d7b8fdd0db6659735cc55b33e7fe749b823ccd9a5ee37b1ccf764ae928"
MD5SUM_aarch64 = "6937d91f3133a63b6e5bb33951c8c2e8"
SHA256SUM_aarch64 = "72c5338003322a4ebf4d28e38f48b3014fcd116bd54d1b42924aa3be32888bd0"
SRC_URI[md5sum] = "${MD5SUM}"
SRC_URI[sha256sum] = "${SHA256SUM}"

# prevent pulling *-dev by packaging needed *.so in regular packages, not
# in imx-gpu-viv-dev.
INSANE_SKIP_libclc-imx += "dev-so"
