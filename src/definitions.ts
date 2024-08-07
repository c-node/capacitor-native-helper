export interface NativeHelperPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
