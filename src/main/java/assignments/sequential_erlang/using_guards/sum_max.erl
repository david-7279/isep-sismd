%%%-------------------------------------------------------------------
%%% @author arch
%%% @copyright (C) 2026, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 27. Apr 2026 10:26 PM
%%%-------------------------------------------------------------------
-module(sum_max).
-export([sum_max/2]).

max_list([X]) -> X;
max_list([H | T]) -> TailMax = max_list(T),
  case H > TailMax of
    true -> H;
    false -> TailMax
  end.

sum_max(L1, L2) -> max_list(L1) + max_list(L2).
