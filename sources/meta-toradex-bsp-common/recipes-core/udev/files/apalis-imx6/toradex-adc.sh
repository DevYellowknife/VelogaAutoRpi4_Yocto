#!/usr/bin/env sh
#
# Called from udev. Compatible to apalis-imx6.
#
# Create/remove symlinks to/from the files with raw ain data.

# Map the ADC lines:
# apalis-adc{0..3} -> STMPE811 ADC{4,5,6,7} in terms of the driver.
LINES=4
START=4

if [ "$ACTION" = "add" ]; then
    for idx in `seq 0 $((LINES-1))`; do
        ln -s "/sys$DEVPATH/in_voltage$((START+idx))_raw" /dev/apalis-ain$idx
    done
elif [ "$ACTION" = "remove" ]; then
    for idx in `seq 0 $((LINES-1))`; do
        rm -f /dev/apalis-ain$idx
    done
fi

