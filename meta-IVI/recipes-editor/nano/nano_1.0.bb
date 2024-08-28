# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Nano text editor"
DESCRIPTION = "GNU Nano is a small, friendly text editor inspired by Pico."

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   COPYING.DOC
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "GPL-3.0-only & Unknown"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949 \
                    file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f"

SRC_URI = "git://git.savannah.gnu.org/git/nano.git/;protocol=https;branch=master"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "d1e2febb6d15db60cbf000c3dfff60b66575c749"

S = "${WORKDIR}/git"

# NOTE: the following library dependencies are unknown, ignoring: curses
#       (this is based on recipes that have previously been built and packaged)
DEPENDS = "ncurses file zlib"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit autotools pkgconfig gettext
inherit autotools-brokensep

# Additional configure options
EXTRA_OECONF = "--enable-feature-x"

# Custom do_configure function
do_configure() {
    :

}

# Custom compile step
do_compile() {
    :
}

# Custom install step
do_install() {
    :
}