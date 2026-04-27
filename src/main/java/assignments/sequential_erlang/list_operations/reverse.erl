%%%-------------------------------------------------------------------
%%% @author arch
%%% @copyright (C) 2026, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 27. Apr 2026 9:56 PM
%%%-------------------------------------------------------------------
-module(reverse).
-export([reverse/1]).

reverse([]) -> [];
reverse([H | T]) -> reverse(T) ++ [H].
