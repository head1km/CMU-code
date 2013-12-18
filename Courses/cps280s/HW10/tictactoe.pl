#!/usr/bin/perl -w

sub main {
	my $players = getPlayers();
	my $first = int(rand(2));
	my @board;
	
	for(my $i = 1; $i < 10; $i++ ) {
		push @board, $i;
	}
	writeBoard(@board);
    startGame($players, $first, \@board);
}

sub getPlayers() {
	my $false = 0;
	
	print "Please enter the number of human players)";
	chomp(my $players = <>);
	while($false == 0) {
		if (grep {/^$players$/} (0..2)) { 
			$false = 1;
		}
		else {
			print "Please enter the number of human players)";
			chomp($players = <>);
		}	
	}
	$players;
}

sub writeBoard {
	system $^O eq 'MSWin32' ? 'cls' : 'clear';
	print"----------\n";
	foreach (@_) {
		if(grep {/^$_$/} (0..10)) {
			if ($_ == 3 || $_ == 6 || $_ == 9) {
            	printf (" %d\n----------\n", $_);
			}
			else { printf(" %d |", $_); }
		}
		else { printf(" %s |", $_); }
	}
	print "\n";
}

sub startGame {
	my $players = shift @_;
	my $first = shift @_;
	my @board = @{$_[0]};
	
	print @board;
	if ($players == 0) { simulate($players, $first, \@board); }
    elsif ($players == 1) { single(@board, $players, $first); }
    else { double(@board, $players, $first); }
}

sub single {
	
}

sub double {
	
}

sub simulate {
	my $players = shift @_;
	my $first = shift @_;
	my @board = @{$_[0]};
	my $moves = 0;
	
    while ($moves < 9) {
        system $^O eq 'MSWin32' ? 'cls' : 'clear';
        if ($first == 0) {
            $player1 = rand(10);
            while (grep {/^$board[$player1]$/} (0..10) eq "") { $player1 = rand(10); }
            $board[$player1] = "X";
            writeBoard(@board);
            checkWin(@board, $players, $first);
            sleep(1);
            $moves += 1;
            if ($moves < 8) {
                system $^O eq 'MSWin32' ? 'cls' : 'clear';
                $player2 = rand(10);
                while (grep {/$board[$player2]$/} (0..10) eq "") { $player2 = rand(10); }
                $board[$player2] = "O";
                writeBoard(@board);
                checkWin(@board, $players, $first);
                sleep(1);
                $moves += 1;
			}
            else { tie($players, $first); }
		}
        else {
            $player2 = rand(10);
            while (grep {/^$board[$player2]$/} (0..10) eq "") { $player2 = rand(10); }
            $board[$player2] = "O";
            writeBoard(@board);
            checkWin(@board, $players, $first);
            sleep(1);
            $moves += 1;
            if ($moves < 8) {
                system $^O eq 'MSWin32' ? 'cls' : 'clear';
                $player1 = rand(10);
                while (grep {/^$board[$player2]$/} (0..10) eq "") { $player1 = rand(10); }
                $board[$player1] = "X";
                writeboard(@board);
                checkWin(@board, $players, $first);
                sleep(1);
                $moves += 1;
            }
            else { tie($players, $first); }
        }
    }
}

sub checkWin {
	@board = shift @_;
	if ($board[0] == "X" && $board[1] == "X" && $board[2] == "X") { win("x", $players, $first); }
    elsif ($board[3] == "X" && $board[4] == "X" && $board[5] == "X") { win("x", $players, $first); }
    elsif ($board[6] == "X" && $board[7] == "X" && $board[8] == "X") { win("x", $players, $first); }
    elsif ($board[0] == "X" && $board[3] == "X" && $board[6] == "X") { win("x", $players, $first); }
    elsif ($board[1] == "X" && $board[4] == "X" && $board[7] == "X") { win("x", $players, $first); }
    elsif ($board[2] == "X" && $board[5] == "X" && $board[8] == "X") { win("x", $players, $first); }
    elsif ($board[0] == "X" && $board[4] == "X" && $board[8] == "X") { win("x", $players, $first); }
    elsif ($board[2] == "X" && $board[4] == "X" && $board[6] == "X") { win("x", $players, $first); }
    elsif ($board[0] == "O" && $board[1] == "O" && $board[2] == "O") { win("o", $players, $first); }
    elsif ($board[3] == "O" && $board[4] == "O" && $board[5] == "O") { win("o", $players, $first); }
    elsif ($board[6] == "O" && $board[7] == "O" && $board[8] == "O") { win("o", $players, $first); }
    elsif ($board[0] == "O" && $board[3] == "O" && $board[6] == "O") { win("o", $players, $first); }
    elsif ($board[1] == "O" && $board[4] == "O" && $board[7] == "O") { win("o", $players, $first); }
    elsif ($board[2] == "O" && $board[5] == "O" && $board[8] == "O") { win("o", $players, $first); }
    elsif ($board[0] == "O" && $board[4] == "O" && $board[8] == "O") { win("o", $players, $first); }
    elsif ($board[2] == "O" && $board[4] == "O" && $board[6] == "O") { win("o", $players, $first); }
}

sub tie {
	my $players = shift @_;
	my $first = shift @_;
	
	print "Tie game!";
    playagain($players, $first);
}

sub win {
	my $winner = shift @_;
	my $players = shift @_;
	my $first = shift @_;
	
	if ($winner == "x") {
        print "Player X wins!";
        playagain($players, $first);
	}
    else {
        print "Player O wins!";
        playagain($players, $first);
    }
}

sub playagain {
	my $players = shift @_;
	my $first = shift @_;
	
	if ($players != 0) {
        print "Enter 'y' to play another game.";
        $again = <>;
        if ($again == "y") {
            my @board;
            for(my $i = 1; $i < 10; $i++ ) {
				push @board, $i;
			}
            writeBoard();
            startGame($players, $first, \@board);
        }
	}
    exit(0);
}

&main();