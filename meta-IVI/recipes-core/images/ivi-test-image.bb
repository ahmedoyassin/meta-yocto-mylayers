# include base image
require recipes-core/images/rpi-test-image.bb

# Set all local variables
SUMMARY = "IVI Testing Image that includes rpi-test-image"

# IMAGE_INSTALL
IMAGE_INSTALL:append=" helloworld openssh"

#IMAGE_FEATURES
IMAGE_FEATURES:append=" dbg-pkgs"
