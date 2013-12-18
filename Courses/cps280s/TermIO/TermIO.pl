#!/usr/bin/perl

#Kyle Head
#22-September-2013
#TermIO.pl
#Read input from standard input only and keep a record of all recorded numbers and strings.
#Stop input when either CTRL+d is entered or an empty line is present.
#When input is finished print out the statistics.

$sum = 0;
@strings;

while(($_ = <STDIN>) =~ /\S/ ) {
	if (/^-?(?:\d+(?:\.\d*)?|\.\d+)$/) { $sum += $_; }
	else { chomp $_; push(@strings, $_); }
}
print "\nThe sum of the numbers is: $sum.\nThe given strings were: @strings\n";