%%%-------------------------------------------------------------------
%%% @author arch
%%% @copyright (C) 2026, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 27. Apr 2026 9:56 PM
%%%-------------------------------------------------------------------
-module(member).
-export([member/2]).

member(_, []) -> false;
member(X, [X | _]) -> true;
member(X, [_ | T]) -> member(X, T).
