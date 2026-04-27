%%%-------------------------------------------------------------------
%%% @author arch
%%% @copyright (C) 2026, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 27. Apr 2026 9:36 PM
%%%-------------------------------------------------------------------
-module(factorial).
-export([factorial/1]).

factorial(0) -> 1;
factorial(N) when N > 0 -> N * factorial(N - 1).