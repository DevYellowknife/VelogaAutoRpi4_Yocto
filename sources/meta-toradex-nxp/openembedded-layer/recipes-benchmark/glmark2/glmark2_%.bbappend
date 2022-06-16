FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

# fixes with Vivante 6.4.0:
# root@apalis-imx8:~# glmark2-es2-wayland
# EGL: Warning: No default display support on wayland
# Error: Loading EGL entry points failed
# Segmentation fault

SRC_URI_append_imxgpu = " file://0001-glad-Fix-EGL-loading-for-EGL_NO_DISPLAY-on-EGL-1.5-a.patch"
