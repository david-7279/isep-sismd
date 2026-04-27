%%%-------------------------------------------------------------------
%%% @author arch
%%% @copyright (C) 2026, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 27. Apr 2026 6:32 PM
%%%-------------------------------------------------------------------
-module(temp_convert).
-export([temp_convert/1]).

temp_convert({C, F}) ->
  {C, 5(F - 32) / 9}.
