# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)


# Documentation Variable
SUMMARY = "This is a recipe file for appssl task"
DESCRIPTION = "to create a new layer, add the C++ application provided to you that depends mainly on the openssl SW package and customize a minimal image to include your application along with additional Image features for debugging purposes."
HOMEPAGE = "/home/yasso/Desktop/appssl"

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file://appssl.cpp"

# Modify these as desired
PV = "1.0"

#adding dependences of openssl
DEPENDS += " openssl"

#debugging techniques gdb
IMAGE_INSTALL += " gdb strace valgrind"
IMAGE_INSTALL += " crash kernel-module-gdb kernel-module-kgdb"
IMAGE_FEATURES += " dev-pkgs"

DEBUG_BUILD = "1"

# Specify any other build or runtime dependencies
#RDEPENDS_${PN} += "openssl"

S = "${WORKDIR}"

# NOTE: no Makefile found, unable to determine what needs to be done

do_package_qa[noexec]="1"

do_compile () {
	# Specify compilation commands here
	#$CXX ${S}/appssl.cpp -o appssl
    #$CXX ${CXXFLAGS} -g -o appssl appssl.cpp -lssl -lcrypto
	$CXX ${S}/appssl.cpp -lssl -lcrypto -o appssl
}

do_install () {
	# Specify install commands here
	install -d ${D}${bindir}
	install -m 0755 appssl ${D}${bindir}
}