// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game-service.proto

package com.caoguzelmas.models;

public interface GameStateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GameState)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Player players = 1;</code>
   */
  java.util.List<com.caoguzelmas.models.Player> 
      getPlayersList();
  /**
   * <code>repeated .Player players = 1;</code>
   */
  com.caoguzelmas.models.Player getPlayers(int index);
  /**
   * <code>repeated .Player players = 1;</code>
   */
  int getPlayersCount();
  /**
   * <code>repeated .Player players = 1;</code>
   */
  java.util.List<? extends com.caoguzelmas.models.PlayerOrBuilder> 
      getPlayersOrBuilderList();
  /**
   * <code>repeated .Player players = 1;</code>
   */
  com.caoguzelmas.models.PlayerOrBuilder getPlayersOrBuilder(
      int index);
}
