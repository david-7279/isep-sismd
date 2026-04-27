%%%-------------------------------------------------------------------
%%% @author arch
%%% @copyright (C) 2026, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 27. Apr 2026 9:57 PM
%%%-------------------------------------------------------------------
-module(average).
-export([average/1]).


sum([]) -> 0;
sum([H | T]) -> H + sum(T).

count([]) -> 0;
count([H | T]) -> 1 + count(T).

average([]) -> [];
average(L) ->  sum(L) / count(L).