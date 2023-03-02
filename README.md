# VelogaAutoRpi4_Yocto

to start >

source ./veloga.sh


make image >
bitbake velogaauto-image

make sdk >
bitbake velogaauto-image -c populate_sdk